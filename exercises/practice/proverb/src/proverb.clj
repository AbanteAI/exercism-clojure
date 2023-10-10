(ns proverb)

(defn recite [inputs]
  (if (empty? inputs)
    ""
    (let [proverb-lines (map #(str "For want of a " %1 " the " %2 " was lost.") inputs (rest inputs))]
      (clojure.string/join "\n" (concat proverb-lines ["And all for the want of a " (first inputs) "."])))))
