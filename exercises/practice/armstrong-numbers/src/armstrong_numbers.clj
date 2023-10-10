(ns armstrong-numbers)

(defn armstrong? [num]
  (let [digits (seq (str num))
        num-digits (count digits)
        sum (reduce + (map #(Math/pow (BigInteger/valueOf (Character/digit % 10)) num-digits) digits))]
    (.equals (BigInteger/valueOf num) sum)))
