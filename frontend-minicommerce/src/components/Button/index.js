import React from "react";
import classes from "./styles.module.css";

const Button = (props) => {
  const { action, children, variant } = props;
  return ( 
        <button 
          onClick={action}
          className={[classes.button, classes[variant]].join(" ")}
        >
          {children}
        </button>
      );
};
export default Button;