# Twitter-Shivam
A POC to use twitter API's

It is a dropwizard application. It contains three API's

1) **Post Tweet:** 

    URL: http://localhost:8080/api/1.0/twitter/tweetService?message={your tweetService}
    
2) **Retrieve Timeline:**

    URL: http://localhost:8080/api/1.0/twitter/timeline
    
3) **Retrieve Timeline By Filter:**

    URL: http://localhost:8080/api/1.0/twitter/timeline/filter?filter=messsage
    
**Running The Application:**
    Run it like a normal dropwizard application giving program arguments as 'server 'confifuration_file.yml''
