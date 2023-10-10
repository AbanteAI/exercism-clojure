(ns kindergarten-garden)
(def plant-names {"V" "Violets" "R" "Radishes" "C" "Clover" "G" "Grass"})
(def students ["Alice" "Bob" "Charlie" "David" "Eve" "Fred" "Ginny" "Harriet" "Ileana" "Joseph" "Kincaid" "Larry"])

(defn garden [diagram students]
  (let [rows (clojure.string/split-lines diagram)
        window-row (first rows)
        away-row (second rows)
        plants-for (fn [idx]
                     (map (fn [plant-initial] (get plant-names plant-initial))
                          [(get window-row (* idx 2)) (get window-row (inc (* idx 2)))
                           (get away-row (* idx 2)) (get away-row (inc (* idx 2)))]))]
    (into {} (map (fn [idx] [(get students idx) (plants-for idx)]) (range 0 (count students))))))
