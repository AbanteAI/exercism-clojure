(ns complex-numbers)

(defn real [[a b]]
  a)

(defn imaginary [[a b]]
  b)

(defn abs [[a b]]
  (Math/sqrt (+ (* a a) (* b b))))

(defn conjugate [[a b]]
  [a (- 0 b)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* a d) (* b c))])

(defn div [[a b] [c d]]
  (let [denom (+ (* c c) (* d d))]
    [(/ (+ (* a c) (* b d)) denom) (/ (- (* b c) (* a d)) denom)]))
