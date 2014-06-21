(ns footpad.test.core
  (:use [footpad.core] :reload)
  (:use [clojure.test])
  (:use [midje.sweet]))

(unfinished)

(fact "Empty room, one by one"
      (generate-room 1 1) => ["###",
			      "# #",
			      "###"])

(fact "Empty room, three by one"
      (generate-room 3 1) => ["#####",
			      "#   #",
			      "#####"])

;.;. Happiness comes when you believe that you have done something truly
;.;. meaningful. -- Yan
(fact "Empty room, two by three"
      (generate-room 2 3) => ["####",
			      "#  #",
			      "#  #",
			      "#  #",
			      "####"])

(fact "Three by one, with single object"
      (generate-room 3 1 [">" 1 1]) => ["#####",
					"#>  #",
					"#####"])

(fact "Three by one, with two objects"
      (generate-room 3 1 [">" 1 1] ["<" 3 1]) => ["#####",
						  "#> <#",
						  "#####"])