(ns octal)

(defn to-decimal [octal-str]
  (if (re-matches #"^[0-7]*$" octal-str)
    (reduce (fn [acc digit]
              (+ (* acc 8) (Character/digit (int digit) 8)))
            0
            octal-str)
    0))
