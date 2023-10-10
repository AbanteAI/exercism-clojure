(ns roman-numerals)
(def roman-numerals-map
  {1000 "M" 900 "CM" 500 "D" 400 "CD" 100 "C" 90 "XC" 50 "L" 40 "XL" 10 "X" 9 "IX" 5 "V" 4 "IV" 1 "I"})

(defn numerals [number]
  (loop [remaining-number number
         roman-numeral ""]
    (if (zero? remaining-number)
      roman-numeral
      (let [[value symbol] (first (filter #(<= (key %) remaining-number) (reverse roman-numerals-map)))]
        (recur (- remaining-number value) (str roman-numeral symbol))))))
