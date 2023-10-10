(ns change)

(defn issue [change coins]
  (if (neg? change) nil
      (let [dp (vec (cons 0 (repeat change Double/POSITIVE_INFINITY)))]
        (doseq [coin coins
                amount (range coin (inc change))]
          (aset dp amount (min (aget dp amount) (inc (aget dp (- amount coin))))))
        (if (= (aget dp change) Double/POSITIVE_INFINITY) nil
            (loop [remaining-change change
                   remaining-coins (reverse coins)
                   result []]
              (if (zero? remaining-change) result
                  (let [coin (first remaining-coins)]
                    (if (<= (- remaining-change coin) 0)
                        (recur remaining-change (rest remaining-coins) result)
                        (recur (- remaining-change coin) remaining-coins (conj result coin))))))))) 
