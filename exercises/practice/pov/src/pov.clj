(ns pov)

(defn of [graph node]
  (let [new-graph (assoc graph node (get graph node #{}) )]
    (reduce (fn [g k] (assoc g k (disj (get g k #{}) node))) new-graph (get graph node #{}) )))

(defn path-from-to [graph from to]
  (loop [path [from] visited #{from}]
    (let [current (peek path)]
      (cond
        (= current to) path
        (empty? (get graph current #{}) ) nil
        :else (if-let [next (some #(when-not (visited %) %) (get graph current #{}) )]
                (recur (conj path next) (conj visited next))
                (recur (pop path) visited))))))
