(ns series)

(defn slices [string length]
  (if (<= length (count string))
    (map (fn [i] (subs string i (+ i length)))
         (range 0 (- (count string) length -1)))
    []))
