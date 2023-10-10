(ns zipper)

(defn from-tree [tree]
  {:tree tree :path []})

(defn value [zipper]
  (:value (:tree zipper)))

(defn left [zipper]
  (let [left-child (:left (:tree zipper))]
    (if left-child
      (assoc zipper :tree left-child :path (conj (:path zipper) :left)))))

(defn right [zipper]
  (let [right-child (:right (:tree zipper))]
    (if right-child
      (assoc zipper :tree right-child :path (conj (:path zipper) :right)))))

(defn to-tree [zipper]
  (:tree zipper))

(defn up [zipper]
  (let [path (:path zipper)]
    (if (empty? path)
      nil
      (assoc zipper :tree (get-in (:tree zipper) (reverse (conj (pop path) :tree))) :path (pop path)))))

(defn set-value [zipper value]
  (assoc-in zipper [:tree :value] value))

(defn set-left [zipper left]
  (assoc-in zipper [:tree :left] left))

(defn set-right [zipper right]
  (assoc-in zipper [:tree :right] right))
