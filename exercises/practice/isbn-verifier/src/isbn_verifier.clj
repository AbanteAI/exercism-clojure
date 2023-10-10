(ns isbn-verifier)

(defn isbn? [isbn]
  (let [cleaned-isbn (clojure.string/replace isbn #"-" "")
        valid-length? (= 10 (count cleaned-isbn))]
    (if valid-length?
      (let [digits (map #(if (= % \X) 10 (Character/digit % 10)) cleaned-isbn)
            valid-X? (or (not (some #{\X} (butlast digits))) (= (last digits) \X))
            weighted-sum (reduce + (map * digits (range 10 0 -1)))]
        (and valid-X? (= 0 (mod weighted-sum 11))))
      false)))
