# ui-markdown [![GitHub Actions status |pink-gorilla/ui-codemirror](https://github.com/pink-gorilla/ui-markdown/workflows/CI/badge.svg)](https://github.com/pink-gorilla/ui-markdown/actions?workflow=CI)[![Clojars Project](https://img.shields.io/clojars/v/org.pinkgorilla/ui-markdown.svg)](https://clojars.org/org.pinkgorilla/ui-markdown)

Everything related to markdown:
- html prose mode
- markdown viewer
- [Prosemirror](https://prosemirror.net/) markdown editor.

## End-Users
- this project is NOT for you! Instead go to:
- [goldly](https://github.com/pink-gorilla/goldly)
- [notebook](https://github.com/pink-gorilla/notebook)

## Demo

```
clojure -X:goldly
```

Navigate your webbrowser to port. 
snippets are in `running systems` / `snippet-registry`

## Use with [goldly](https://github.com/pink-gorilla/goldly)

This library provides the pinkie ui renderer 
  [:p/markdown]
  [:p/prosemirror]
  and the css class .prose


Add this alias to your deps.edn:

```
 :goldly
  {:extra-deps {org.pinkgorilla/goldly {:mvn/version "0.2.39"}
                org.pinkgorilla/ui-markdown {:mvn/version "0.0.3"}}
   :exec-fn goldly-server.app/goldly-server-run!
   :exec-args {:profile "watch"
               :config {:goldly {}}}}
```


## Use outside of goldly and webly

- We use goldly and webly to manage css and for snippet examples.
- You can create a custom clojurescript project with shadow-cljs 
  and ignore `src/goldly`.