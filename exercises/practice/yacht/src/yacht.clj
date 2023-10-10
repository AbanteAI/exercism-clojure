(ns yacht)

(defn count-dice [dice face]
  (count (filter #(= % face) dice)))

(defn full-house [dice]
  (let [counts (map #(count-dice dice %) (distinct dice))]
    (if (and (= 2 (count (distinct counts))) (some #(= % 3) counts))
      (apply + dice)
      0)))

(defn four-of-a-kind [dice]
  (let [counts (map #(count-dice dice %) (distinct dice))]
    (if (some #(>= % 4) counts)
      (* 4 (first (filter #(>= (count-dice dice %) 4) (distinct dice))))
      0)))

(defn little-straight [dice]
  (if (= (set dice) #{1 2 3 4 5})
    30
    0))

(defn big-straight [dice]
  (if (= (set dice) #{2 3 4 5 6})
    30
    0))

(defn choice [dice]
  (apply + dice))

(defn yacht [dice]
  (if (= 1 (count (distinct dice)))
    50
    0))
(defn score [dice category]
  (case category
    "ones" (* 1 (count-dice dice 1))
    "twos" (* 2 (count-dice dice 2))
    "threes" (* 3 (count-dice dice 3))
    "fours" (* 4 (count-dice dice 4))
    "fives" (* 5 (count-dice dice 5))
    "sixes" (* 6 (count-dice dice 6))
    "full-house" (full-house dice)
    "four-of-a-kind" (four-of-a-kind dice)
    "little-straight" (little-straight dice)
    "big-straight" (big-straight dice)
    "choice" (choice dice)
    "yacht" (yacht dice)
    0))
