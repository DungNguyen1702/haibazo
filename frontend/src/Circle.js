import React, { useState } from "react";

const Circle = ({
    number,
    onClick,
    position,
    nextNumber,
    totalCircles,
    gameStatus,
}) => {
    const [isFading, setIsFading] = useState(false);

    const handleClick = () => {
        if (gameStatus !== "Playing") return;
        if (number === nextNumber) {
            setIsFading(true);
        }
        onClick(number);
    };

    return (
        <div
            onClick={handleClick}
            style={{
                width: "40px",
                height: "40px",
                borderRadius: "50%",
                border: "2px solid black",
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                position: "absolute",
                left: position.left,
                top: position.top,
                backgroundColor: isFading ? "red" : "white",
                transition: "background-color 0.6s ease",
                fontWeight: "bold",
                zIndex: totalCircles - number,
            }}
        >
            {number}
        </div>
    );
};

export default Circle;
