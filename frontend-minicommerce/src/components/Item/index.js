import React from "react";
import classes from "./styles.module.css";
import Button from "../../components/Button";

const Item = (props) => {
    const { id, title, price, description, category, quantity, sold, handleEdit, handleDelete , handleAddToCart, handleAddQuantity} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <p>{`stok: ${quantity}`}</p>

            <Button action={handleEdit} variant="primary">
                Edit
            </Button>
            <Button action={handleDelete} variant="danger">
                Delete
            </Button>

         
           <div className={classes.flex}>
           <form>
                <input
                    className={classes.textField} type="number" placeholder="Mau beli berapa"
                    name="sold" 
                    onChange={handleAddQuantity}/>
             </form>
              
                    <Button action={handleAddToCart} variant="add">
                            Add to Cart
                    </Button>
           </div>
          
           
        </div>

    );
};
export default Item;
