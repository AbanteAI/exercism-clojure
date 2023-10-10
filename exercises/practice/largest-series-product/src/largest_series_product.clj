(ns largest-series-product)

(defn str-to-digits [s]
  (map #(Character/digit % 10) s))
(defn largest-product [input span]
  (let [digits (str-to-digits input)]
    (if (<= span 0)
      1
      (apply max
             (map #(reduce * %)
                  (map (partial map #(Character/digit % 10))
                       (partition span 1 digits)))))))