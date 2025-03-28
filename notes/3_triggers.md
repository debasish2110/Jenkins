# Triggers in Jenkins

Triggers in Jenkins determine **when a job or pipeline should start** automatically. These triggers help automate workflows based on events like code changes, time schedules, or external signals.

---

## **Common Jenkins Triggers**

### **1. SCM Polling (`Poll SCM`)**
- Jenkins periodically checks the source code repository for changes.
- If changes are detected, the job is triggered.
- Example cron syntax (every 5 minutes):
  ```
  H/5 * * * *
  ```

### **2. Webhook Trigger (GitHub/GitLab)**
- Uses **webhooks** to trigger jobs immediately when code is pushed.
- Requires plugins like:
  - **GitHub Plugin** (for GitHub Webhooks)
  - **GitLab Plugin** (for GitLab Webhooks)

### **3. Build After Other Projects (Upstream Jobs)**
- A job can be triggered **after another job completes**.
- Useful for **multi-stage** build pipelines.

### **4. Periodic Build (Cron Schedule)**
- Triggers a build **at a fixed schedule**.
- Example cron expressions:

  | Cron Expression | Meaning |
  |---------------|---------|
  | `H 0 * * *` | Runs daily at midnight |
  | `H/15 * * * *` | Runs every 15 minutes |
  | `H 12 * * 1-5` | Runs at noon on weekdays |

### **5. Manual Trigger (Build Now)**
- User manually starts the job via the **Jenkins UI** or CLI.

### **6. Parameterized Builds**
- Jobs are triggered with **user-defined parameters**.
- Example: A job triggered with a **specific branch name**.

### **7. Remote API Trigger**
- Jenkins jobs can be triggered **via API requests**.
- Example **cURL command**:
  ```bash
  curl -X POST http://JENKINS_URL/job/JOB_NAME/build?token=YOUR_TOKEN
  ```

### **8. Event-Based Triggers (Jenkinsfile)**
- In **Declarative Pipelines**, you can use `triggers {}` in a `Jenkinsfile`:
  ```groovy
  pipeline {
      triggers {
          pollSCM('H/5 * * * *')  // Poll SCM every 5 minutes
      }
      stages {
          stage('Build') {
              steps {
                  echo 'Building the project...'
              }
          }
      }
  }
  ```

---

## **Choosing the Right Trigger**

| Use Case | Best Trigger |
|----------|-------------|
| Start a job when code changes | Webhook (GitHub/GitLab) |
| Schedule job at fixed times | Cron-based trigger |
| Trigger a job after another | Upstream job trigger |
| Manual execution | Build Now |
| API-based triggering | Remote API trigger |

