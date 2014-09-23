package org.triiskelion.tinyutils;

import java.util.ArrayList;
import java.util.List;


public class StopWatch {

	private final String id;

	/** Start time of the current task */
	private long startTimeMillis;

	private long lastMarkTimeMillis;

	private long endTimeMillis;

	/** Is the stop watch currently running? */
	private boolean running;


	int markCount = 0;

	List<Mark> markList = new ArrayList<>();


	/**
	 * Construct a new stop watch. Does not start any task.
	 */
	public StopWatch() {

		this.id = "";
	}

	/**
	 * Construct a new stop watch with the given id.
	 * Does not start any task.
	 *
	 * @param id
	 * 		identifier for this stop watch.
	 * 		Handy when we have output from multiple stop watches
	 * 		and need to distinguish between them.
	 */
	public StopWatch(String id) {

		this.id = id;
	}


	public StopWatch start() throws IllegalStateException {

		if(this.running) {
			throw new IllegalStateException("Can't start StopWatch: it's already running");
		}
		this.startTimeMillis = System.currentTimeMillis();
		this.lastMarkTimeMillis = startTimeMillis;
		this.running = true;
		return this;
	}

	boolean inLoop = false;

	Mark loopMark = null;

	public void beginLoop(String name) {

		mark("**BEFORE Loop[" + name + "]**");
		loopMark = new Mark(markCount, name, lastMarkTimeMillis);
		loopMark.isLoopMark = true;
		markCount++;
	}

	public void markLoop() {

		loopMark.loop();
	}

	public void endLoop() {

		long time = System.currentTimeMillis();
		loopMark.setEndTimeMillis(time);
		markList.add(loopMark);
		loopMark = null;
		inLoop = false;

		lastMarkTimeMillis = time;
	}

	public void mark() {

		mark(null);
	}

	public void mark(int i) {

		mark(String.valueOf(i));
	}

	public void mark(String name) {

		if(inLoop) {

			return;
		}
		long time = System.currentTimeMillis();
		markList.add(new Mark(markCount, name, lastMarkTimeMillis, time));
		lastMarkTimeMillis = time;
		markCount++;
	}


	/**
	 * Return whether the stop watch is currently running.
	 */
	public boolean isRunning() {

		return this.running;
	}

	/**
	 * Stop the current task. The results are undefined if timing
	 * methods are called without invoking at least one pair
	 * {@link #start()} / {@link #stop()} methods.
	 *
	 * @see #start()
	 */
	public void stop() throws IllegalStateException {

		if(!this.running) {
			throw new IllegalStateException("Can't stop StopWatch: it's not running");
		}
		long lastTime = System.currentTimeMillis() - this.startTimeMillis;
		markList.add(new Mark(markCount, "**END**", lastMarkTimeMillis,
				System.currentTimeMillis()));
		this.running = false;
	}


	/**
	 * Return the total time in milliseconds for all tasks.
	 */
	public long getTotalTimeMillis() {

		long totalTimeMillis = 0;
		for(Mark mark : markList) {
			totalTimeMillis += mark.getElapsedTimeMillis();
		}
		return totalTimeMillis;
	}

	/**
	 * Return the total time in seconds for all tasks.
	 */
	public double getTotalTimeSeconds() {

		return this.getTotalTimeMillis() / 1000.0;
	}

	/**
	 * Return a string with a table describing all tasks performed.
	 * For custom reporting, call getTaskInfo() and use the task info directly.
	 */
	public String prettyString() {

		StringBuilder builder = new StringBuilder();
		builder.append(String.format("StopWatch[%s]:\n", id));
		for(Mark mark : markList) {
			builder.append("-----> (")
			       .append(mark.getElapsedTimeMillis()).append(" ms");
			if(mark.isLoopMark) {
				builder.append(": Looped ").append(mark.loopCount).append(" time(s)")
				       .append(" min:").append(mark.minimumLoopTime).append("ms")
				       .append(" avg:").append(mark.averageLoopTime).append("ms")
				       .append(" max:").append(mark.maximumLoopTime).append("ms");
			}
			builder.append(") -----> ")
			       .append(mark.getName() == null ? "Mark:" + mark.getIndex() : mark.getName())
			       .append("\n");
		}
		builder.append("Total time: ").append(getTotalTimeMillis()).append(" ms.");
		return builder.toString();
	}

	public void prettyPrint() {

		System.out.println(prettyString());
	}


	private static class Mark {

		private int index;

		private String name;

		private long startTimeMillis;

		private long endTimeMillis;

		private boolean isLoopMark = false;

		private long loopCount = 0;

		private long minimumLoopTime = Long.MAX_VALUE;

		private long maximumLoopTime = 0;

		private long averageLoopTime;

		private long loopStartTime;

		private void loop() {

			long time = System.currentTimeMillis();
			long loopTime = time - loopStartTime;
			if(loopTime < minimumLoopTime) {
				minimumLoopTime = loopTime;
			} else if(loopTime > maximumLoopTime) {
				maximumLoopTime = loopTime;
			}
			averageLoopTime = (averageLoopTime * loopCount + loopTime) / (loopCount + 1);

			loopStartTime = time;
			loopCount++;
		}

		private Mark(int index, String name, long startTimeMillis) {

			this.index = index;
			this.name = name;
			this.startTimeMillis = startTimeMillis;
			this.loopStartTime = this.startTimeMillis;
		}

		private Mark(int index, String name, long startTimeMillis, long endTimeMillis) {

			this.index = index;
			this.name = name;
			this.startTimeMillis = startTimeMillis;
			this.loopStartTime = this.startTimeMillis;
			this.endTimeMillis = endTimeMillis;
		}

		public long getElapsedTimeMillis() {

			return endTimeMillis - startTimeMillis;
		}

		public int getIndex() {

			return index;
		}

		public void setIndex(int index) {

			this.index = index;
		}

		public String getName() {

			return name;
		}

		public void setName(String name) {

			this.name = name;
		}

		public long getStartTimeMillis() {

			return startTimeMillis;
		}

		public void setStartTimeMillis(long startTimeMillis) {

			this.startTimeMillis = startTimeMillis;
		}

		public long getEndTimeMillis() {

			return endTimeMillis;
		}

		public void setEndTimeMillis(long endTimeMillis) {

			this.endTimeMillis = endTimeMillis;
		}
	}


}
