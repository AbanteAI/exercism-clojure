(ns robot-simulator)

(defn robot
  [x y direction]
  {:position [x y] :direction direction})

(defn simulate
  [robot instructions]
  (loop [robot robot
         instrs (seq instructions)]
    (if (empty? instrs)
      robot
            new-robot (cond
                        (= instr \R) (turn-right robot)
                        (= instr \L) (turn-left robot)
                        (= instr \A) (advance robot)
                        :else robot)]
        (recur new-robot (rest instrs))))))

(defn turn-right
  [robot]
  (update robot :direction #(mod (+ % 1) 4)))

(defn turn-left
  [robot]
  (update robot :direction #(mod (- % 1) 4)))

(defn advance
  [robot]
  (let [direction (get robot :direction)
        position (get robot :position)
        new-position (case direction
                       0 [(+ (first position) 0) (+ (second position) 1)]
                       1 [(+ (first position) 1) (+ (second position) 0)]
                       2 [(+ (first position) 0) (- (second position) 1)]
                       3 [(- (first position) 1) (+ (second position) 0)])]
    (assoc robot :position new-position)))
