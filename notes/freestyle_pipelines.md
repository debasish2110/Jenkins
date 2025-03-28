# Freestyle Pipeline

A **Freestyle Pipeline** (also called a **Freestyle Project**) is a type of job in **Jenkins**, the open-source automation server. It provides a flexible way to configure and execute build, test, and deployment tasks through a simple UI-driven approach.

## Key Features of Freestyle Pipeline
- **UI-Based Configuration:** No need to write code; you configure jobs through the Jenkins web interface.
- **Multiple Build Steps:** Supports executing shell scripts, running batch commands, triggering other builds, or integrating with SCM tools like Git.
- **Plugin Support:** Can be extended with Jenkins plugins to integrate with Docker, AWS, Selenium, and more.
- **Scheduling & Triggers:** Can be triggered manually, on a schedule (cron), after another job, or via SCM changes.
- **Post-Build Actions:** Supports actions like sending email notifications, archiving artifacts, or publishing test results.

## Freestyle Pipeline vs. Declarative/Scripted Pipelines
| Feature | Freestyle Pipeline | Declarative/Scripted Pipeline |
|---------|-------------------|-----------------------------|
| **Configuration** | UI-based | Code-based (Jenkinsfile) |
| **Flexibility** | Limited | Highly flexible |
| **Version Control** | Not easy to track | Easily stored in Git |
| **Scripting** | Minimal (shell/batch possible) | Uses Groovy for complex logic |
| **Best For** | Simple automation tasks | CI/CD pipelines, complex workflows |

## When to Use a Freestyle Pipeline?
- When you need a **quick and simple** automation job.
- If your pipeline **doesn't require complex branching, approvals, or parameterized builds**.
- When working with legacy projects that do not require full-fledged CI/CD.

For advanced automation needs, **Jenkins Pipelines (Declarative or Scripted)** using a `Jenkinsfile` are recommended.

