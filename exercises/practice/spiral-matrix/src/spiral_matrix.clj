(ns spiral-matrix)

(defn spiral [n]
  (let [matrix (vec (mapv vec (repeat n (repeat n 0))))
        directions [[0 1] [1 0] [0 -1] [-1 0]]
        step (fn [pos dir] (map + pos dir))]
    (loop [pos [0 0]
           dir 0
           num 1
           matrix matrix]
      (if (> num (* n n))
        matrix
        (let [updated-matrix (assoc-in matrix pos num)
              next-pos (step pos (directions dir))
              next-dir (if (and (every? #(<= 0 % (dec n)) next-pos)
                                (= 0 (get-in updated-matrix next-pos)))
                          dir
                          (mod (inc dir) 4))]
          (recur next-pos next-dir (inc num) updated-matrix))))))
