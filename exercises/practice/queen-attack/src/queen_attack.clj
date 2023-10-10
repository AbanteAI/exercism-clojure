(ns queen-attack)

(defn board-string [white-queen black-queen]
  (let [board (vec (repeat 8 (vec (repeat 8 "."))))]
    (-> board
        (assoc-in white-queen "W")
        (assoc-in black-queen "B")
        (mapv #(clojure.string/join " " %))
        (clojure.string/join "\n")
        (str "\n"))))

(defn can-attack [white-queen black-queen]
  (let [[wx wy] white-queen
        [bx by] black-queen]
    (or (= wx bx)
        (= wy by)
        (= (Math/abs (- wx bx)) (Math/abs (- wy by))))))
