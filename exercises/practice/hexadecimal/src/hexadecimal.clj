(ns hexadecimal)

(defn hex-to-int [hex-string]
  (let [hex-digits {"0" 0 "1" 1 "2" 2 "3" 3 "4" 4 "5" 5 "6" 6 "7" 7 "8" 8 "9" 9 "a" 10 "b" 11 "c" 12 "d" 13 "e" 14 "f" 15}]
    (loop [hex-chars (seq hex-string) decimal 0]
      (if (empty? hex-chars)
        decimal
        (let [hex-char (clojure.string/lower-case (first hex-chars))
              hex-value (hex-digits hex-char)]
          (if (nil? hex-value)
            (return 0)
            (recur (next hex-chars) (+ (* decimal 16) hex-value))))))))
