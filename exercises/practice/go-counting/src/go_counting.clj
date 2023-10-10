(ns go-counting)

(defn valid-pos? [grid [x y]]
  (and (>= x 0) (>= y 0) (< y (count grid)) (< x (count (first grid)))))

(defn neighbors [grid [x y]]
  (filter #(valid-pos? grid %)
          [[(dec x) y] [(inc x) y] [x (dec y)] [x (inc y)]]))

(defn dfs [grid visited [x y] player]
  (if (or (contains? visited [x y]) (not (valid-pos? grid [x y])) (not= (get-in grid [y x]) player))
    visited
    (reduce #(dfs grid %1 %2 player) (conj visited [x y]) (neighbors grid [x y]))))

(defn find-territory [grid [x y]]
  (let [player (get-in grid [y x])]
    (if (or (= player :black) (= player :white))
      nil
      (let [visited (dfs grid #{} [x y] player)]
        (if (empty? visited)
          nil
          {:owner (if (= player :empty) :none player) :territory visited})))))

(defn territory [grid [x y]]
  (find-territory grid [x y]))

(defn territories [grid]
  (reduce (fn [acc pos]
            (let [t (find-territory grid pos)]
              (if t
                (update-in acc [(:owner t)] #(into %1 (:territory t)))
                acc)))
          {:black #{} :white #{} :none #{}}
          (for [y (range (count grid))
                x (range (count (first grid)))]
            [x y])))
