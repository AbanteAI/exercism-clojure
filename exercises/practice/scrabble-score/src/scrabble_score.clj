(ns scrabble-score)

(defn score-letter [letter]
  (let [letter-upper (clojure.string/upper-case letter)]
    (cond
      (contains? #{"A" "E" "I" "O" "U" "L" "N" "R" "S" "T"} letter-upper) 1
      (contains? #{"D" "G"} letter-upper) 2
      (contains? #{"B" "C" "M" "P"} letter-upper) 3
      (contains? #{"F" "H" "V" "W" "Y"} letter-upper) 4
      (= "K" letter-upper) 5
      (contains? #{"J" "X"} letter-upper) 8
      (contains? #{"Q" "Z"} letter-upper) 10
      :else 0)))

(defn score-word [word]
  (reduce (fn [total-score letter] (+ total-score (score-letter letter))) 0 word))
