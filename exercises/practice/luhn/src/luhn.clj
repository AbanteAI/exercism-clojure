(ns luhn)

(defn valid? [number]
  (let [cleaned-number (clojure.string/replace number #"\s" "")
        digits (map #(Character/digit % 10) cleaned-number)
        valid-input? (and (>= (count cleaned-number) 2)
                          (every? #(Character/isDigit %) cleaned-number))]
    (if (not valid-input?)
      false
      (let [doubled-digits (map-indexed (fn [index digit]
                                          (if (odd? index)
                                            digit
                                            (let [doubled (* 2 digit)]
                                              (if (> doubled 9)
                                                (- doubled 9)
                                                doubled))))
                                        (reverse digits))
            total (reduce + doubled-digits)]
            total (reduce + doubled-digits)]
        (zero? (mod total 10))))))
