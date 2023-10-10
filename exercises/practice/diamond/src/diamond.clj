(ns diamond)

(defn diamond [letter]
  (let [size (- (int letter) 64)
        build-row (fn [i]
                    (let [spaces (apply str (repeat (- size i) " "))
                          letter (char (+ 64 i))]
                      (if (= i 1)
                        (str spaces letter spaces)
                        (str spaces letter (apply str (repeat (- (* 2 i) 3) " ")) letter spaces))))]
    (concat
     (map build-row (range 1 (inc size)))
     (reverse (map build-row (range 1 size))))))
