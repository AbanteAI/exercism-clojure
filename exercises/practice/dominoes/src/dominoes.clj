(ns dominoes)

(defn rotations [domino]
  [domino (reverse domino)])

(defn chains [dominoes]
  (let [start (first dominoes)
        remaining (rest dominoes)]
    (if (empty? remaining)
      (list start)
      (for [next (mapcat rotations remaining)
            :when (= (second start) (first next))
            chain (chains (remove #{next} remaining))]
        (cons start chain)))))

(defn can-chain? [dominoes]
  (let [counts (frequencies (flatten dominoes))
        odd-counts (count (filter odd? (vals counts)))]
    (if (empty? dominoes)
      true
      (and (<= odd-counts 2)
           (or (= odd-counts 0)
               (some #(= (first %) (second %))
                     (mapcat #(list % (reverse %)) dominoes)))))))
(defn can-chain? [] ;; <- arglist goes here
  ;; your code goes here
)
