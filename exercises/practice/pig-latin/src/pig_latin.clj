(ns pig-latin)
(defn first-vowel-index [word]
  (loop [i 0]
    (let [c (nth word i)]
      (cond
        (>= i (count word)) i
        (is-vowel? c) i
        (and (= c \q) (= (nth word (inc i)) \u)) (+ i 2)
        (and (> i 0) (= c \y)) i
        :else (recur (inc i))))))
(defn is-vowel? [c]
  (contains? #{\a \e \i \o \u \A \E \I \O \U} c))

(defn translate [word]
  (let [index (first-vowel-index word)
        prefix (subs word 0 index)
        suffix (subs word index)]
    (cond
      (or (is-vowel? (first word)) (#{\x \y} (first word)) (#{\X \Y} (first word)))
      (str word "ay")
      :else
      (str suffix prefix "ay"))))
