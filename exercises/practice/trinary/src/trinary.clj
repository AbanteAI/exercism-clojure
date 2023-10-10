(ns trinary)

(defn to-decimal [trinary-str]
  (if (re-matches #"^[0-2]*$" trinary-str)
    (reduce
      (fn [acc value] (+ (* acc 3) (Character/digit value 10)))
      0
      trinary-str)
    0))
