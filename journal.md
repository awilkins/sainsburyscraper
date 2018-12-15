# Dev journal

## Step 0

* Create a project with a POM file
* Add some dependencies for tests

## Step 1 - first recon

* Grab the source page
* Examine it
  * If it's XHTML, this will be much easier...
  * `xmllint page.html` - oh well, it isn't

## Step 2 - building blocks

Reckon it will be probably easiest to grab this data using CSS selectors on the page.
Let's look for a library that can execute CSS selectors in a web page in Java.

After a very brief search... [jsoup](https://jsoup.org) seems to be the obvious choice. Well, it was
first in the search results.

We're also going to need something to help us serialize to JSON and it seems that [Gson](https://github.com/google/gson)
is a reasonable choice for this.

