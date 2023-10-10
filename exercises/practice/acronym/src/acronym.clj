(ns acronym)

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> (clojure.string/split phrase #"[ -]")
       (mapcat clojure.string/split-lines)
       (map clojure.string/upper-case)
       (map first)
       (apply str)))
