(ns matching-brackets)

(defn valid? [s]
  (let [bracket-map { \) \(, \] \[, \} \{ }]
    (loop [chars (seq s) stack []]
      (if-let [c (first chars)]
        (cond
          (contains? bracket-map c)
            (if (= (peek stack) (bracket-map c))
              (recur (next chars) (pop stack))
              false)
          (contains? (set (vals bracket-map)) c)
            (recur (next chars) (conj stack c))
          :else
            (recur (next chars) stack))
        (empty? stack)))))
