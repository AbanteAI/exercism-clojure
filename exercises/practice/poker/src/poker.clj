(ns poker)


(defn parse-card [card]
  (let [[value suit] card]
    [(get {:2 2 :3 3 :4 4 :5 5 :6 6 :7 7 :8 8 :9 9 :T 10 :J 11 :Q 12 :K 13 :A 14} value) suit]))

(defn hand-rank [hand]
  (let [cards (map parse-card hand)
        values (map first cards)
        suits (map second cards)
        same-value-counts (frequencies values)
        same-suit? (apply = suits)
        consecutive? (let [min-max (apply min-max values)]
                       (= (range (first min-max) (inc (second min-max))) values))]
    (cond
      (and same-suit? consecutive?) [0 (last values)] ;; Straight flush
      (= 4 (apply max (vals same-value-counts))) [1 (key (find (fn [[k v]] (= v 4)) same-value-counts))] ;; Four of a kind
      (and (= 3 (apply max (vals same-value-counts))) (= 2 (apply min (vals same-value-counts)))) [2 (key (find (fn [[k v]] (= v 3)) same-value-counts))] ;; Full house
      same-suit? [3 (last (sort values))] ;; Flush
      consecutive? [4 (last values)] ;; Straight
      (= 3 (apply max (vals same-value-counts))) [5 (key (find (fn [[k v]] (= v 3)) same-value-counts))] ;; Three of a kind
      (let [pairs (filter (fn [[k v]] (= v 2)) same-value-counts)]
        (if (= 2 (count pairs)) [6 (apply max (map key pairs))] ;; Two pairs
            (if (= 1 (count pairs)) [7 (key (first pairs))] ;; One pair
                [8 (last (sort values))])))))) ;; High card

(defn highest-card [hand1 hand2]
  (let [hand1-values (map first (map parse-card hand1))
        hand2-values (map first (map parse-card hand2))]
    (if (> (apply max hand1-values) (apply max hand2-values)) hand1 hand2)))

(defn best-hands [hands]
  (let [ranked-hands (map (fn [hand] [hand (hand-rank hand)]) hands)
        best-rank (apply min (map (fn [[_ rank]] (first rank)) ranked-hands))
        best-hands (filter (fn [[_ rank]] (= best-rank (first rank))) ranked-hands)]
    (if (= 1 (count best-hands))
      (first (first best-hands))
      (let [tie-break-rank (apply min (map (fn [[_ rank]] (second rank)) best-hands))
            tie-break-hands (filter (fn [[_ rank]] (= tie-break-rank (second rank))) best-hands)]
        (if (= 1 (count tie-break-hands))
          (first (first tie-break-hands))
          (map first (reduce (fn [acc [hand1 rank1] [hand2 rank2]]
                               (if (= rank1 rank2) (conj acc hand1 hand2) (highest-card hand1 hand2)))
                             []
                             tie-break-hands)))))))