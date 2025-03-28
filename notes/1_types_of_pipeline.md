# Jenkins Pipeline Types

Jenkins provides several types of pipelines for different CI/CD needs. Below is a breakdown of the major pipeline types and their use cases.

---

## **1. Declarative Pipeline**
**Definition:** A structured and user-friendly way to define CI/CD pipelines using a predefined syntax.

**Best For:** Simpler and standardized pipelines with clear stages.

### **Example:**
```groovy
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
            }
        }
    }
}
```

✅ **Pros:**
- Easier to write and maintain.
- Built-in error handling (`post` block).
- Supports `when` conditions for conditional execution.

---

## **2. Scripted Pipeline (Groovy Pipeline)**
**Definition:** Uses Groovy scripting to define the pipeline, allowing greater flexibility.

**Best For:** Complex pipelines requiring custom logic.

### **Example:**
```groovy
node {
    stage('Build') {
        echo 'Building...'
    }
    stage('Test') {
        echo 'Testing...'
    }
    stage('Deploy') {
        echo 'Deploying...'
    }
}
```

✅ **Pros:**
- Full flexibility with Groovy scripting.
- Can use loops, conditions, and functions.

---

## **3. Multibranch Pipeline**
**Definition:** A pipeline that automatically detects branches in a repository and runs pipelines accordingly.

**Best For:** CI/CD for multiple branches in a Git repository (e.g., `dev`, `staging`, `main`).

### **Setup:**
- Configure a **Jenkinsfile** in each branch.
- Jenkins will automatically create and manage jobs for each branch.

✅ **Pros:**
- Automates pipeline creation per branch.
- Supports feature branch workflows in Git.
- Ideal for GitHub, GitLab, and Bitbucket integration.

---

## **4. Pipeline as Code (Jenkinsfile)**
**Definition:** Storing the pipeline definition as a **Jenkinsfile** inside the repository.

**Best For:** Teams following Infrastructure as Code (IaC) and version-controlled CI/CD pipelines.

✅ **Pros:**
- Version-controlled pipeline configuration.
- Collaboration-friendly.

---

## **5. Shared Library Pipeline**
**Definition:** A reusable set of pipeline functions stored in a separate Git repository.

**Best For:** Large teams managing multiple projects with reusable pipeline logic.

### **Example:**
```groovy
@Library('my-shared-library') _
pipeline {
    agent any
    stages {
        stage('Custom Stage') {
            steps {
                myCustomFunction()
            }
        }
    }
}
```

✅ **Pros:**
- Promotes **code reuse** across pipelines.
- Reduces duplication and maintenance effort.

---

## **6. Parallel Pipeline**
**Definition:** A pipeline that runs multiple stages simultaneously.

**Best For:** Running independent tasks in parallel (e.g., unit tests, integration tests).

### **Example:**
```groovy
pipeline {
    agent any
    stages {
        stage('Parallel Execution') {
            parallel {
                stage('Unit Tests') {
                    steps {
                        echo 'Running unit tests...'
                    }
                }
                stage('Integration Tests') {
                    steps {
                        echo 'Running integration tests...'
                    }
                }
            }
        }
    }
}
```

✅ **Pros:**
- Improves **build speed** by running tasks in parallel.
- Efficient for test automation and large builds.

---

## **7. Matrix Pipeline**
**Definition:** A pipeline that runs the same steps across different configurations (e.g., OS versions, browsers).

**Best For:** Cross-platform or cross-browser testing.

### **Example:**
```groovy
pipeline {
    agent any
    matrix {
        axes {
            axis {
                name 'OS'
                values 'Linux', 'Windows'
            }
        }
        stages {
            stage('Test') {
                steps {
                    echo "Running tests on ${OS}"
                }
            }
        }
    }
}
```

✅ **Pros:**
- Automates **multi-environment** testing.
- Useful for cloud-based and platform-dependent deployments.

---

## **Which Pipeline to Choose?**
| Type | When to Use? |
|------|-------------|
| **Declarative** | Standardized, simple CI/CD workflows |
| **Scripted** | Complex pipelines requiring Groovy logic |
| **Multibranch** | Managing pipelines for multiple branches |
| **Jenkinsfile** | Version-controlled pipeline management |
| **Shared Library** | Reusing common pipeline logic across projects |
| **Parallel** | Running independent jobs simultaneously |
| **Matrix** | Testing across multiple environments |

---

## **Conclusion**
Jenkins offers a variety of pipeline types for different CI/CD needs. Choose the one that best fits your project requirements to optimize build automation and deployment workflows.

---

