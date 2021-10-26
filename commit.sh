#!/bin/sh

echo "Commit message: "
read message

git add .
git commit -a "$message"
git push

echo "All done"