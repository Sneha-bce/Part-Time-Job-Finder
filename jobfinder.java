import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Job {
    private String title;
    private String company;
    private String location;
    private String description;

    public Job(String title, String company, String location, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "Job Title: " + title + "\nCompany: " + company + "\nLocation: " + location + "\nDescription: " + description;
    }
}

class JobFinder {
    private List<Job> jobList;

    public JobFinder() {
        jobList = new ArrayList<>();
    }

    public void addJob(Job job) {
        jobList.add(job);
    }

    public List<Job> searchJobs(String keyword) {
        List<Job> results = new ArrayList<>();
        for (Job job : jobList) {
            if (job.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                job.getDescription().toLowerCase().contains(keyword.toLowerCase()) ||
                job.getLocation().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(job);
            }
        }
        return results;
    }
}

public class JobFinderApp {
    public static void main(String[] args) {
        JobFinder jobFinder = new JobFinder();

        // Adding some jobs
        jobFinder.addJob(new Job("Retail Assistant", "ABC Store", "Mumbai", "Part-time retail assistant needed for weekends."));
        jobFinder.addJob(new Job("Content Writer", "XYZ Media", "Remote", "Looking for freelance content writers."));
        jobFinder.addJob(new Job("Delivery Person", "Fast Couriers", "Bangalore", "Part-time delivery job in the evenings."));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Part-Time Job Finder");
        System.out.print("Enter keyword to search for jobs: ");
        String keyword = scanner.nextLine();

        List<Job> results = jobFinder.searchJobs(keyword);
        if (results.isEmpty()) {
            System.out.println("No jobs found for keyword: " + keyword);
        } else {
            System.out.println("Jobs found:");
            for (Job job : results) {
                System.out.println("-----------------------------");
                System.out.println(job);
            }
        }
        scanner.close();
    }
}
