import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/Modal";
import SearchBar from "../../components/SearchBar";
import CartItem from "../../components/CartItem";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";
import ViewStreamIcon from '@mui/icons-material/ViewStream';

class ItemList extends Component {
    constructor(props) {
        super(props);

        this.state = {
            items: [
            ],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            sold: 0,
            cartItems: [],
            cartHidden: true

        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleDeleteItem = this.handleDeleteItem.bind(this);
        this.handleSubmitAddItem = this.handleSubmitAddItem.bind(this);
        this.handleDeleteAll = this.handleDeleteAll.bind(this);
        // this.handleSearchItem= this.handleSearchItem.bind(this.query);
        // this.setQuery = this.setQuery.bind(this);
    }
    componentDidMount() {
        this.loadData();
        console.log("componentDidMount()");
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }


    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleAddItem() {
        this.setState({ isCreate: true });
    }


    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        console.log(this.state.sold)
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity,
        })
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleCancel(event) {

        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }


    async handleDeleteItem(id) {
        try {
            await APIConfig.delete(`/item/${id}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleDeleteAll() {
        try {
            await APIConfig.get("/cart/checkout");
            alert("Berhasil Checkout!")
            this.loadGetCartData();

        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }


    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity,
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0,
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");

            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitAddItem(item) {
        console.log("HELLO DI HANDLE SUBMIT ADD ITEM")
        try {
            if (item.quantity >= this.state.sold) {
                const data = {
                    idItem: item.id,
                    quantity: this.state.sold,
                };
                await APIConfig.post("/cart", data);
                this.setState({
                    sold: 0
                })
                this.loadGetCartData();
            } else {
                alert("Stok tidak cukup");
            }


        } catch (error) {
            alert("Oops terjadi masalah pada server");

            console.log(error);
        }
    }

    decreaseQuantity = (sold) => {
        if (this.state.quantity - sold >= 0) {
            this.state.quantity -= sold;
            return true;
        } else {
            alert("Stok tidak cukup")
            return false;
        }
    }

    increaseQuantity = (sold) => {
        this.state.quantity += sold;
    }


    async loadGetCartData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ cartItems: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }


    handleToggle = () => {
        console.log(this.state.cartHidden)
        const cartHidden = this.state.cartHidden;
        this.setState({ cartHidden: !cartHidden });
        console.log(this.state.cartHidden)
    };

    async handleSearchItem(search) {
        if (search === "") this.loadData();
        else {
            const filtered = this.state.items.filter(item => {
                return item.title.toLowerCase().includes(search.toLowerCase())
            })
            this.setState({ input: search });
            this.setState({ items: filtered });
        }
    }



    render() {
        return (
            <div className="container pt-3">
                <div className="row mt-3">
                    {this.state.cartHidden ? (

                        <div className="col-sm">
                            
                            <Button action={this.handleToggle} variant="back" >
                                Back
                            </Button>
                            <h1 className={classes.title}>My Cart</h1>
                            {this.state.cartItems.length > 0 ? (
                                <Button action={this.handleDeleteAll} variant="checkout" >
                                    Checkout
                                </Button>) : null}
                                {this.state.cartItems.length === 0 ? (
                                <div className={classes.info}>
                                    <h1>Belum ada item yang dipilih</h1>
                                    <h3>Klik salah satu item di List Item</h3>
                                </div>
                            ) : null}
                            <div>
                                {this.state.cartItems.map((cart) => (<CartItem
                                    key={cart.id}
                                    id={cart.id}
                                    title={cart.item.title} price={cart.item.price} description={cart.item.description} category={cart.item.category}
                                    quantity={cart.quantity}
                                />
                                ))} </div>

                        </div>
                    ) : (
                        <div className={classes.itemList}> <h1 className={classes.title}>
                            All Items
                        </h1>
                            <SearchBar handleChange={(e) => this.handleSearchItem(e.target.value)} />
                            <div style={{ position: "fixed", top: 25, right: 25 }}>
                                <Fab variant="extended" onClick={this.handleToggle}>
                                    {/* {this.state.cartHidden ? ( */}
                                    {/* {this.state.cartHidden} */}
                                    <Badge
                                        color="secondary"
                                        badgeContent={this.state.cartItems.length}
                                    >
                                        <ShoppingCartIcon />
                                    </Badge>
                                    {/* ) : (
                                        <ViewStreamIcon />
                                    )} */}
                                </Fab>
                            </div>
                            <br></br>
                            <br></br>
                            <Button action={this.handleAddItem} variant="primary">
                                Add Item
                            </Button>
                            <div>
                                {this.state.items.map((item) => (<Item
                                    key={item.id}
                                    id={item.id}
                                    title={item.title} price={item.price} description={item.description} category={item.category} quantity={item.quantity} sold={item.sold}
                                    handleEdit={() => this.handleEditItem(item)}
                                    handleDelete={() => this.handleDeleteItem(item.id)}
                                    handleAddQuantity={(event) => this.handleChangeField(event)}
                                    handleAddToCart={() => this.handleSubmitAddItem(item)}
                                />
                                ))} </div>
                        </div>



                    )}

                    <Modal

                        show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel} modalTitle={this.state.isCreate
                            ? "Add Item"
                            : `Edit Item ID ${this.state.id}`} >
                        <form> <input
                            className={classes.textField} type="text"
                            placeholder="Nama Item" name="title"
                            value={this.state.title} onChange={this.handleChangeField} />
                            <input
                                className={classes.textField} type="number" placeholder="Harga"
                                name="price"
                                value={this.state.price} onChange={this.handleChangeField}
                            />
                            <textarea className={classes.textField} placeholder="Deskripsi" name="description"
                                rows="4"
                                value={this.state.description} onChange={this.handleChangeField}
                            />
                            <input
                                className={classes.textField} type="text"
                                placeholder="Kategori" name="category" value={this.state.category} onChange={this.handleChangeField}
                            />
                            <input
                                className={classes.textField} type="number"
                                placeholder="qty"
                                name="quantity" value={this.state.quantity} onChange={this.handleChangeField}
                            />
                            <Button action={this.state.isCreate
                                ? this.handleSubmitItem
                                : this.handleSubmitEditItem} variant="primary"
                            >
                                Create
                            </Button>

                            <Button action={this.handleCancel} variant="danger">
                                Cancel
                            </Button> </form>
                    </Modal>
                </div>

            </div>
        );
    }
}
export default ItemList;
