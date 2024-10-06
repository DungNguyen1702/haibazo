import React, { useState, useEffect } from "react";
import Circle from "./Circle";

function App() {
    const [points, setPoints] = useState(3);
    const [circles, setCircles] = useState([]);
    const [nextNumber, setNextNumber] = useState(1);
    const [startTime, setStartTime] = useState(null);
    const [elapsedTime, setElapsedTime] = useState(0);
    const [gameStarted, setGameStarted] = useState(false);
    const [gameStatus, setGameStatus] = useState("Playing");

    useEffect(() => {
        if (gameStarted) {
            let newCircles = Array.from({ length: points }, (_, index) => {
                let randomLeft = Math.random() * 100;
                let randomTop = Math.random() * 100;

                const minPercent = (42 / 500) * 100;

                let computedLeft =
                    randomLeft < minPercent
                        ? "0%"
                        : `calc(${randomLeft}% - 42px)`;
                let computedTop =
                    randomTop < minPercent
                        ? "0%"
                        : `calc(${randomTop}% - 42px)`;

                return {
                    number: index + 1,
                    position: {
                        left: computedLeft,
                        top: computedTop,
                    },
                };
            });

            setCircles(newCircles);
            setStartTime(new Date());
            setGameStatus("Playing");
        }
    }, [gameStarted]);

    useEffect(() => {
        if (startTime && gameStatus === "Playing") {
            const timer = setInterval(() => {
                setElapsedTime(((new Date() - startTime) / 1000).toFixed(1));
            }, 100);
            return () => clearInterval(timer);
        }
    }, [startTime, gameStatus]);

    const handleCircleClick = (number) => {
        if (gameStatus !== "Playing") return;

        if (number === nextNumber) {
            setTimeout(() => {
                setCircles((prevCircles) =>
                    prevCircles.filter((circle) => circle.number !== number)
                );
            }, 600);

            if (circles.length === 1) {
                setGameStatus("All Clear");
            } else {
                setNextNumber(nextNumber + 1);
            }
        } else {
            setGameStatus("Game Over");
        }
    };

    const handlePlayOrRestart = () => {
        setNextNumber(1);
        setStartTime(new Date());
        setGameStarted(true);
        setGameStatus("Playing");
        setElapsedTime(0);

        let newCircles = Array.from({ length: points }, (_, index) => {
            let randomLeft = Math.random() * 100;
            let randomTop = Math.random() * 100;

            const minPercent = (42 / 500) * 100;

            let computedLeft =
                randomLeft < minPercent ? "0%" : `calc(${randomLeft}% - 42px)`;
            let computedTop =
                randomTop < minPercent ? "0%" : `calc(${randomTop}% - 42px)`;

            return {
                number: index + 1,
                position: {
                    left: computedLeft,
                    top: computedTop,
                },
            };
        });
        setCircles(newCircles);
    };

    const handlePointsChange = (e) => {
        if (gameStatus === "Game over" || gameStatus === "All Clear") return;

        let value = e.target.value;

        if (/^\d*$/.test(value)) {
            if (value === "" || Number(value) <= 0) {
                setPoints(0);
            } else {
                setPoints(Number(value));
            }
        }
        setNextNumber(1);
    };

    return (
        <div style={{ textAlign: "center" }}>
            <h1
                style={{
                    color:
                        gameStatus === "All Clear"
                            ? "green"
                            : gameStatus === "Game Over"
                            ? "red"
                            : "black",
                }}
            >
                {gameStatus === "All Clear"
                    ? "ALL CLEAR"
                    : gameStatus === "Game Over"
                    ? "GAME OVER"
                    : "LET'S PLAY"}
            </h1>
            <div>
                <label>Points: </label>
                <input
                    type="text"
                    value={points}
                    onChange={handlePointsChange}
                    min="1"
                    max="100"
                />
            </div>
            <div>Time: {elapsedTime}s</div>

            <button onClick={handlePlayOrRestart}>
                {gameStarted ? "Restart" : "Play"}
            </button>

            <div
                style={{
                    position: "relative",
                    width: "500px",
                    height: "500px",
                    margin: "20px auto",
                    border: "2px solid black",
                }}
            >
                {circles.map((circle) => (
                    <Circle
                        key={circle.number}
                        number={circle.number}
                        onClick={handleCircleClick}
                        position={circle.position}
                        nextNumber={nextNumber}
                        totalCircles={points}
                        gameStatus={gameStatus}
                    />
                ))}
            </div>
        </div>
    );
}

export default App;
