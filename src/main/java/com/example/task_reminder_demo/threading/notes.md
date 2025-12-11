# Multi-Threading
- Program
- CPU -> single, multi-core
- Tasks
- Process
- Thread

- Multi-tasking
- Multi-Thread

- Time Slicing and Context Switching
- t1 - t2

- JVM -> Multi-Threading
- IO -> 2*CPU Cores
- Worker Thread -> 8 or 16 * IO

- Java 21/25 Virtual Thread
- OS/Platform Thread -> Heavy Lifting
- JVM Virtual Threads
- OS Thread
- IO bound
- CPU intensive

- java.util.concurrent

- ASYNC
- task1 x task2

- extend Thread
- implement Runnable
  - DON't expect any return
  - successful value, or an exception
- implement Callable
  - expect any return
  - successful value, or an exception

- User Threads
- Daemon Threads
- Priority
- 1-10