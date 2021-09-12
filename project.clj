(defproject gameoflife-clojure "0.1.0-SNAPSHOT"
    :description "Game of Life in Clojure, for Coderetreat facilitators, teachers, learners, anyone who's interested"
    :url "https://github.com/nelkinda/gameoflife-clojure"
    :license {
        :name "GPL-3.0-or-later"
        :url "https://choosealicense.com/licenses/gpl-3.0"
    }
    :dependencies [
        [org.clojure/clojure "1.10.3"]
    ]
    :plugins [
        [com.siili/lein-cucumber "1.0.7"]
    ]
    :main ^:skip-aot gameoflife-clojure.core
    :target-path "target/%s"
    :cucumber-feature-paths ["test/features/"]
    :profiles {
        :uberjar {
            :aot :all
            :jvm-opts ["-Dclojure.compiler.direct-linking=true"]
        }
        :dev {
            :dependencies [[com.siili/lein-cucumber "1.0.7"]]
        }
    }
)
