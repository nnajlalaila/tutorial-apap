import React from "react";
import classes from "./styles.module.css";
const CartItem = (props) => {
    const { id,  title, price, description, category, quantity} = props;
    const totalPrice = quantity * price;

    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Jumlah: ${quantity}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Category: ${category}`}</p>
            <p>{`Total Harga: ${totalPrice}`}</p>
        </div>
    );
};
export default CartItem;