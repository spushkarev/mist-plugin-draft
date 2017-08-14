Draft/prototype for mist plugin

project setup:


`sbt`:
```
mistServer := "localhost:2004" // host port to mist
devName := "vadim_che" // prefix for deploing/running jobs in dev mode

name := "my-awesome-job"
version := "0.1.1"
```

`scr/main/resources/deploy.conf`:
```
endpoints = [
  {
    "name": "SimpleContext$",
    "bind-path": "simple-context"
  },
  {
    "name": "Another$",
    "bind-path": "another"
  }
]

```

commands:
- `sbt devDeployOnMist`
   build jar, upload it on mist, configure context
   for simple-context endpoint will be available at path "/vadim_che_my-awesome-job_0.1.1_simple_context"
   endpoint will be available at path "/vadim_che-my-awesome-job_0.1.1"

- `sbt testOnMist` - devDeploy + run
- `sbt releaseOnMist` - try to deploy at "/simple-context" endpoint
