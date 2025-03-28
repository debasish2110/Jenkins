# Jenkins - CI/CD Automation Server

Jenkins is an open-source **automation server** widely used for **Continuous Integration (CI) and Continuous Delivery (CD)** in software development. It helps automate the process of building, testing, and deploying applications, making DevOps practices more efficient and reliable.

---

## **Key Features**

- **Continuous Integration (CI)**: Automatically integrates code changes from multiple developers into a shared repository.
- **Continuous Delivery (CD)**: Enables automatic deployment of applications to different environments.
- **Extensible with Plugins**: Supports **1,800+ plugins** for integrations with Git, Docker, Kubernetes, AWS, and more.
- **Distributed Architecture**: Uses **master-agent** architecture for scalability and parallel execution.
- **Pipeline as Code**: Uses **Jenkinsfile** (written in Groovy) to define CI/CD workflows.
- **Integration with DevOps Tools**: Works with Git, Bitbucket, AWS, Azure, Docker, Kubernetes, etc.

---

## **Jenkins Architecture**

### **1. Jenkins Master**
- Controls job execution and assigns tasks to agents.
- Maintains job configurations and logs.

### **2. Jenkins Agent (Slave)**
- Executes build jobs as instructed by the master.
- Can run on multiple OS (Windows, Linux, macOS).

### **3. Build Executor**
- Runs build tasks inside Jenkins agents.

### **4. Job or Project**
- Represents a task (e.g., compiling code, running tests, deploying applications).

---

## **How Jenkins Works?**

1. **Developer pushes code** → Jenkins detects changes (via webhooks or polling).
2. **Build stage starts** → Jenkins pulls the latest code, compiles, and runs tests.
3. **Testing stage** → Jenkins executes unit, integration, or UI tests.
4. **Deployment stage** → If tests pass, Jenkins deploys the application.

---

## **Jenkins Pipelines**

Jenkins Pipelines are written in **Groovy** and automate CI/CD workflows.

### **Declarative Pipeline (Recommended)**
```groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
            }
        }
    }
}
```

### **Scripted Pipeline**
```groovy
node {
    stage('Build') {
        echo 'Building the application...'
    }
    stage('Test') {
        echo 'Running tests...'
    }
    stage('Deploy') {
        echo 'Deploying application...'
    }
}
```

---

## **Jenkins Installation**

### **On Windows**
1. Download Jenkins **.war** file from [Jenkins website](https://www.jenkins.io/download/).
2. Run:
   ```sh
   java -jar jenkins.war
   ```
3. Access Jenkins at `http://localhost:8080`.

### **On amazon Linux**
#### first install java-17
```sh
sudo dnf update -y
sudo dnf install java-17-amazon-corretto -y
java -version
```

#### then download and install jenkins
```sh
sudo dnf install -y wget
wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io-2023.key
sudo dnf install -y jenkins
```
### ** start jenkins **
```sh
sudo systemctl enable jenkins
sudo systemctl start jenkins
sudo systemctl status jenkins
```
4. Access Jenkins at `http://<ec2-public-ip>:8080`.

---

## **Jenkins with Docker**
To run Jenkins in a Docker container:

### Install Docker
```sh
sudo dnf install -y docker
```
### Start and enable Docker:
```sh
sudo systemctl start docker
sudo systemctl enable docker
```
### pull latest LTS jenkins image
```sh
docker pull jenkins/jenkins:lts
```
### to check if the jenkins image is available
```sh
docker images
```

### run the jenkins container
```sh
docker run -dt -p 8080:8080 jenkins/jenkins
```

### check if container is running
```sh
docker ps
```

### get the initial password for jenkins
```sh
docker exec -it <container_id> cat /var/jenkins_home/secrets/initialAdminPassword
```


---

## **Jenkins vs Other CI/CD Tools**

| Feature           | Jenkins  | GitHub Actions | GitLab CI/CD | CircleCI |
|------------------|---------|--------------|-------------|---------|
| Open Source      | ✅       | ❌           | ✅           | ❌       |
| Plugins Support  | ✅ 1800+ | ❌ Limited   | ✅ Built-in  | ✅       |
| Cloud-Native     | ❌       | ✅           | ✅           | ✅       |
| Ease of Setup    | Moderate | Easy        | Moderate    | Easy    |

---

## **Conclusion**
Jenkins is a **powerful and flexible CI/CD automation server** widely used in DevOps. It supports **automation, extensibility via plugins, distributed builds, and integration with modern tools** like Docker, Kubernetes, and cloud platforms.

