(ns grade-school)

(defn grade [school grade]
    (sort (get school grade [])))

(defn add [school name grade]
    (update school grade (fnil (fn [students] (->> students (conj name) sort)) []) name))
(defn sorted [school]
    (into {}
          (map (fn [[grade students]] [grade (sort students)]))
          (sort-by key school)))
