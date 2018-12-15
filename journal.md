# Dev journal

## Step 0

* Create a project with a POM file
* Add some dependencies for tests

## Step 1

* Grab the source page
* Examine it
  * If it's XHTML, this will be much easier...
  * `xmllint page.html` - oh well, it isn't

## Step 2

Reckon it will be probably easiest to grab this data using CSS selectors on the page.
Let's look for a library that can execute CSS selectors in a web page in Java.

After a very brief search... [jsoup](https://jsoup.org) seems to be the obvious choice. Well, it was
first in the search results.

 