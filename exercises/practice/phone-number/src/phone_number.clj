(ns phone-number)

(defn number
(defn- valid-code? [code]
  (let [first-digit (first code)]
    (and (>= first-digit \2) (<= first-digit \9))))
  [phone]
  (let [digits (clojure.string/join (re-seq #"\d" phone))]
    (if (and (<= 10 (count digits) 11)
             (or (= (count digits) 10) (= (first digits) "1"))
             (valid-code? (subs digits (if (= (count digits) 11) 2 1) 4))
             (valid-code? (subs digits (if (= (count digits) 11) 5 4) 7)))
      (if (= (count digits) 11)
        (subs digits 1)
        digits)
      "0000000000"))
  )
