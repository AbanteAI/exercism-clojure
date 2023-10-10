(ns binary)

(defn to-decimal [binary-string]
  (try
    (reduce (fn [acc cur] (+ (* acc 2) (if (= cur \1) 1 0)))
            0
            (if (re-matches #"^[01]*$" binary-string)
              binary-string
              (throw (IllegalArgumentException. "Invalid binary string"))))
    (catch IllegalArgumentException e 0)))
