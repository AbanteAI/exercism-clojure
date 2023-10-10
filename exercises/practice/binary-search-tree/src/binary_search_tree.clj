(ns binary-search-tree)

(defn value [node]
  (:value node))

(defn singleton [v]
  {:value v :left nil :right nil})

(defn insert [node v]
  (if (nil? node)
    (singleton v)
    (let [node-value (:value node)]
      (cond
        (< v node-value) (assoc node :left (insert (:left node) v))
        (> v node-value) (assoc node :right (insert (:right node) v))
        :else node))))

(defn left [node]
  (:left node))

(defn right [node]
  (:right node))

(defn to-list [node]
  (if (nil? node)
    []
    (concat (to-list (:left node)) [(value node)] (to-list (:right node)))))

(defn from-list [values]
  (reduce insert nil values))
