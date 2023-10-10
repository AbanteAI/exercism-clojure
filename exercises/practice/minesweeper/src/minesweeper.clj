(ns minesweeper)

(defn count_mines [board row col]
  (let [rows (count board)
        cols (count (first board))
        neighbors [[-1 -1] [-1 0] [-1 1] [0 -1] [0 1] [1 -1] [1 0] [1 1]]]
    (count (filter #(= \* (get-in board [(+ row (first %)) (+ col (second %))] \space))
                   (filter #(and (<= 0 (+ row (first %))) (< (+ row (first %)) rows)
                                 (<= 0 (+ col (second %))) (< (+ col (second %)) cols))
                           neighbors)))))
(defn draw [board]
  (let [rows (count board)
        cols (count (first board))]
    (map (fn [row]
           (apply str
                  (map (fn [col]
                         (let [cell (get-in board [row col])]
                           (if (= cell \*)
                             \*
                             (let [mines (count_mines board row col)]
                               (if (zero? mines)
                                 \space
                                 (str mines))))))
                       (range cols))))
         (range rows))))
