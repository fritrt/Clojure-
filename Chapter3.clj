;; (2015) Clojure for the Brave and True
;; Exercises for the Chapter 3


["a" "vector" "of" "strings"]
(+ 1 2 3)
(str "It was the panda " "in the library " "with a dust buster.")
;Use () for function calls and grouping expressions.
;Use [] for creating vectors, which are ordered collections of elements.
;Use {} for creating maps, which are collections of key-value pairs.

; if,do,when, nil, if nil
(if false
  "By Zeus's hammer!" ;first operand is the then branch
  "By Aquaman's trident!") ;2nd operand is the else branch
(if false
  "By Odin's Elbow!")
(if true
  (do (println "Success!") ;do- wraps up multiple forms in a parentheses and run each of them
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

(if false ;should print the 2nd operand
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))

(when true ; combo of if and do but no else branch
  (println "Success!")
  "abra cadabra"
  (println "Success!")
  "abra cadabra")


(when false ; returns nil since no else branch
  (println "Success!")
  "abra cadabra")

(nil? 1) ; is 1 nil? should be false
(nil? nil); is nil nil? should be true

(if "bears eat beets"
  "bears beets Battlestar Galactica") ; logically true

(if "grace"
  "Grace Olos")

(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

(if nil
  "Eddie"
  "Grace")

; equality operator
(= 1 1)
(= nil nil)
(= 1 2)

; or, and.or

(or false nil :large_I_mean_venti :why_cant_I_just_say_large)
; first truthy value without evaluating the others
(or (= 0 1) (= "yes" "no"))
; or evaluates the truthy value but since both statements are false. I think this is good for looking something in a list.
(or nil)
(and :free_wifi :hot_coffee)
; and returns the first falsey value, if all truthy returns the last truthy value
(and :feelin_super_cool nil false) 
; nil and false are both falsy value, and returns the first falsey value

;!!!!!!Naming values with def

(def failed-protagonist-names
  ["Larry Potter" "Doreen the Explorer" "The Incredible Bulk"])

failed-protagonist-names


(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE "
       (if (= severity :mild)
         "MILDLY INCONVENIENCED!"
         "DOOOOOOOMED!")))
;(error-message :mild)
(error-message nil)

;DATA-STRUCTURES

failed-protagonist-names = [
                            "Larry Potter"
                            "Doreen the Explorer"
                            "The Incredible Bulk"
]
failed-protagonist-names[1] = "Gary Potter"

failed-protagonist-names

; all of Clojure's data structures are immutable so on above lines Larry Potter is not changed with Gary Potter

;NUMBERS
;INTEGER = 95
;FLOAT = 2.9
;RATIO = 1/5

;STRINGS = "5"

;!!!!!!
(defn name []
  "Chewbacca")
(str "\"Uggllglglglglglglll\" - " name)

(defn name []
  "Chewbacca")
(str "\"Uggllglglglglglglll\" - " (name))

;MAPS - hash maps and sorted maps
(hash-map :a 1 :b 2)
;get - looking up values in a map
(get {:a 0 :b 2} :b)

(get {:a 0 :b {:c "ho hum"} :c "unicorns!"} :c)

;get-in lets you look up values in nested maps
(get-in {:a 0 :b {:c "get-me"}} [:b :c])

({:name "The Human Coffeepot"} :name)
;you can use this in looking up values using a keyword

;KEYWORDS

(:a {:a 0 :b 1 :c 2}) ;returns 0
(get {:a 1 :b 2 :c 3} :a) ; returns 1
(:d {:a 5 :b 6 :x 7} "Yeap!") ; returns Yeap

;VECTORS
(get ["X" "Y" "Z"] 2)
(get ["g" {:action "Get me"} :c] 0)
;create vector
(vector "a" "b" "c")
;conj vector
(conj [1 2 3] 5 "a" :h)

;LISTS

'(1 2 3 4)
(nth '(:a :b :c) 2)
(list 1 "two" :a {3 4})
; can use conj as well, and elements are added in the beginning of the list
(conj '(1 2 3 4) 5)
; if you need to add items at the start or writing a macro, you use lis

;SETS
;kinds;hash sets and sorted sets
;hash-sets #####
#{"kurt von" 20 :icicle}
;output of values excluding duplicates
(hash-set 1 1 11 3 3 5 5)
(conj #{:a :b} :b)
;output is from most number of occurences then lowest to highest
(set [5 4 4 3 6 6 4])

;contains?
(contains? #{:f :g} 4)
(contains? #{nil} nil)
(:a #{:a :b})
(get #{:s :x} :s)
(get #{nil :a} nil)
(get #{:a :b} "grace")

;FUNCTIONS
;increase value by 1 using inc
(map inc[1 2 3])
(inc 2.3)
;
(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West")
;
(defn codger-communication
  [whippersnapper]
  (str "Get off my lawn, " whippersnapper "!!!"))
(defn codger
  [& whippersnappers]
  (map codger-communication whippersnappers))

(codger (list "Grace" "Billy" "Anne-Marie"))

;
(defn favorite-things
  [name & things]
  (str "Hi " name ", here are my favorite things: "
       (clojure.string/join ", " things)))
(favorite-things "Doreen" "gum" "shoes")

;OK
(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))
(number-comment 5)
(number-comment 7)

;ANONYMOUS FUNCTIONS

; (fn [param-list] function body)

(map (fn [name] (str "Hi, " name))
     ["Jess" "Ella"])

(#(* % 3) 8)

;RETURNING FUNCTIONS; inc-maker

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)



;LET
(let [x 6
      y 3]
  (+ x y))

(defn add
  []
  (let [x 6
        y 3]
    (+ x y)))
(add)

(def z 2)

; LOOP
(defn lp [iteration]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (lp (inc iteration))))
(lp 0)

; MACROEXPAND
(macroexpand '(when true
               (println "Hi")))

; REGULAR-EXPRESSIONS

(re-find #"^left-" "left-eye")
(re-find #"^left-" "cleft-chin") 
(re-find #"^left-" "wongleblart")

(defn matching-part
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})
(matching-part {:name "left-eye" :size 1})

(matching-part {:name "head" :size 3})

;; sum with reduce
(reduce + [1 2 3 4])
(reduce + #{1 2 3 4})
(defn my-reduce
  ([f initial coll]
   (loop [result initial
          remaining coll]
     (if (empty? remaining)
       result
       (recur (f result (first remaining)) (rest remaining)))))
  ([f [head & tail]]
   (my-reduce f head tail)))



; EXERCISES Chapter 3
; 1
(str "Got it")
'(1 2 3)
(vector :a :b :s)
(hash-map :a 1 :v 2)
(hash-set 1 2 3 3 3 4 5)

; 2 - function that adds 100 to a value
(defn add-100 
  [n]
  (+ n 100))
(add-100 1)

; 3 - dec-maker, function that subtract the two values instead of adding

(defn dec-maker
  
  [dec-by]
  #(- dec-by %))
(def dec3 (dec-maker 3))

(dec3 7)

; 4 function that works like a map except the return value is a set

(defn mapset 
  [f coll]
  (set(map f coll))) ;returns set
  
(mapset inc [1 1 2 2]) 

(defn mapset2
  [f coll]
  (mapv f (set coll))) ;returns list

(mapset2 inc [1 1 2 2])

; 5 


;; REDUCE
(reduce + [1.2 2.2 2.2])
(reduce max [1.2 2.2 2.2])
(reduce - [2 3 4])
(reduce + [2 2 2])
(reduce + 3 [2 2 2])
(reduce max 6 [1 2 3])

(def numbers
  (range 1 10))
(reduce + numbers)

(def scores
  {:clojure 10
   :scala 9
   :jruby 8})
(reduce + (vals scores))

(reduce + 10 (vals scores))


;; FILTER

(filter even? (range 10))
(filterv even? (range 10)) ;; returns a vector

(mapv inc [1 2 3])