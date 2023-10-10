(ns raindrops)

(defn convert [n]
  (let [factors (concat (if (zero? (mod n 3)) ["Pling"] [])
                        (if (zero? (mod n 5)) ["Plang"] [])
                        (if (zero? (mod n 7)) ["Plong"] []))]
    (if (empty? factors)
      (str n)
      (apply str factors))))
